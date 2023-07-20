import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { FicheFormService, FicheFormGroup } from './fiche-form.service';
import { IFiche } from '../fiche.model';
import { FicheService } from '../service/fiche.service';
import { IPathologie } from 'app/entities/pathologie/pathologie.model';
import { PathologieService } from 'app/entities/pathologie/service/pathologie.service';
import { esexe } from 'app/entities/enumerations/esexe.model';
import { estatut } from 'app/entities/enumerations/estatut.model';
import { ecirconstance } from 'app/entities/enumerations/ecirconstance.model';
import { elieudeces } from 'app/entities/enumerations/elieudeces.model';
import { econsanguinite } from 'app/entities/enumerations/econsanguinite.model';
import { egouvernorat } from 'app/entities/enumerations/egouvernorat.model';
import { egouvernoratmere } from 'app/entities/enumerations/egouvernoratmere.model';
import { ecouverture } from 'app/entities/enumerations/ecouverture.model';
import { eactivite } from 'app/entities/enumerations/eactivite.model';
import { escolarisetype } from 'app/entities/enumerations/escolarisetype.model';
import { eniveauscolarisation } from 'app/entities/enumerations/eniveauscolarisation.model';
import { ecasfamiliaux } from 'app/entities/enumerations/ecasfamiliaux.model';
import { edecesbasage } from 'app/entities/enumerations/edecesbasage.model';
import { ecircondecouverte } from 'app/entities/enumerations/ecircondecouverte.model';
import { eage_premier_symptome } from 'app/entities/enumerations/eage-premier-symptome.model';
import { eagepremiereconsultation } from 'app/entities/enumerations/eagepremiereconsultation.model';

@Component({
  selector: 'jhi-fiche-update',
  templateUrl: './fiche-update.component.html',
})
export class FicheUpdateComponent implements OnInit {
  isSaving = false;
  fiche: IFiche | null = null;
  esexeValues = Object.keys(esexe);
  estatutValues = Object.keys(estatut);
  ecirconstanceValues = Object.keys(ecirconstance);
  elieudecesValues = Object.keys(elieudeces);
  econsanguiniteValues = Object.keys(econsanguinite);
  egouvernoratValues = Object.keys(egouvernorat);
  egouvernoratmereValues = Object.keys(egouvernoratmere);
  ecouvertureValues = Object.keys(ecouverture);
  eactiviteValues = Object.keys(eactivite);
  escolarisetypeValues = Object.keys(escolarisetype);
  eniveauscolarisationValues = Object.keys(eniveauscolarisation);
  ecasfamiliauxValues = Object.keys(ecasfamiliaux);
  edecesbasageValues = Object.keys(edecesbasage);
  ecircondecouverteValues = Object.keys(ecircondecouverte);
  eage_premier_symptomeValues = Object.keys(eage_premier_symptome);
  eagepremiereconsultationValues = Object.keys(eagepremiereconsultation);

  pathologiesSharedCollection: IPathologie[] = [];

  editForm: FicheFormGroup = this.ficheFormService.createFicheFormGroup();

  constructor(
    protected ficheService: FicheService,
    protected ficheFormService: FicheFormService,
    protected pathologieService: PathologieService,
    protected activatedRoute: ActivatedRoute
  ) {}

  comparePathologie = (o1: IPathologie | null, o2: IPathologie | null): boolean => this.pathologieService.comparePathologie(o1, o2);

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ fiche }) => {
      this.fiche = fiche;
      if (fiche) {
        this.updateForm(fiche);
      }

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const fiche = this.ficheFormService.getFiche(this.editForm);
    if (fiche.id !== null) {
      this.subscribeToSaveResponse(this.ficheService.update(fiche));
    } else {
      this.subscribeToSaveResponse(this.ficheService.create(fiche));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFiche>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(fiche: IFiche): void {
    this.fiche = fiche;
    this.ficheFormService.resetForm(this.editForm, fiche);

    this.pathologiesSharedCollection = this.pathologieService.addPathologieToCollectionIfMissing<IPathologie>(
      this.pathologiesSharedCollection,
      fiche.pathologie
    );
  }

  protected loadRelationshipsOptions(): void {
    this.pathologieService
      .query()
      .pipe(map((res: HttpResponse<IPathologie[]>) => res.body ?? []))
      .pipe(
        map((pathologies: IPathologie[]) =>
          this.pathologieService.addPathologieToCollectionIfMissing<IPathologie>(pathologies, this.fiche?.pathologie)
        )
      )
      .subscribe((pathologies: IPathologie[]) => (this.pathologiesSharedCollection = pathologies));
  }
}
