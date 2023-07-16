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

@Component({
  selector: 'jhi-fiche-update',
  templateUrl: './fiche-update.component.html',
})
export class FicheUpdateComponent implements OnInit {
  isSaving = false;
  fiche: IFiche | null = null;

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
