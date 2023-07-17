import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IFiche, NewFiche } from '../fiche.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IFiche for edit and NewFicheFormGroupInput for create.
 */
type FicheFormGroupInput = IFiche | PartialWithRequiredKeyOf<NewFiche>;

type FicheFormDefaults = Pick<NewFiche, 'id' | 'btravail' | 'scolarise'>;

type FicheFormGroupContent = {
  id: FormControl<IFiche['id'] | NewFiche['id']>;
  datemaj: FormControl<IFiche['datemaj']>;
  type_observation: FormControl<IFiche['type_observation']>;
  identifiant_registre: FormControl<IFiche['identifiant_registre']>;
  date_enregistrement: FormControl<IFiche['date_enregistrement']>;
  sexe: FormControl<IFiche['sexe']>;
  date_naissance: FormControl<IFiche['date_naissance']>;
  statut: FormControl<IFiche['statut']>;
  date_deces: FormControl<IFiche['date_deces']>;
  circonstance_deces: FormControl<IFiche['circonstance_deces']>;
  autre_circonstance_deces: FormControl<IFiche['autre_circonstance_deces']>;
  lieu_deces: FormControl<IFiche['lieu_deces']>;
  consanguinite: FormControl<IFiche['consanguinite']>;
  origine_geo_pere_gouvernorat: FormControl<IFiche['origine_geo_pere_gouvernorat']>;
  origine_geo_mere_gouvernorat: FormControl<IFiche['origine_geo_mere_gouvernorat']>;
  origine_geo_pere_deleguation: FormControl<IFiche['origine_geo_pere_deleguation']>;
  origine_geo_mere_deleguation: FormControl<IFiche['origine_geo_mere_deleguation']>;
  couverture_sociale: FormControl<IFiche['couverture_sociale']>;
  autre_couverture_sociale: FormControl<IFiche['autre_couverture_sociale']>;
  activite: FormControl<IFiche['activite']>;
  btravail: FormControl<IFiche['btravail']>;
  travail: FormControl<IFiche['travail']>;
  scolarise: FormControl<IFiche['scolarise']>;
  type_scolarise: FormControl<IFiche['type_scolarise']>;
  niveau_scolarisation: FormControl<IFiche['niveau_scolarisation']>;
  pathologie: FormControl<IFiche['pathologie']>;
};

export type FicheFormGroup = FormGroup<FicheFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class FicheFormService {
  createFicheFormGroup(fiche: FicheFormGroupInput = { id: null }): FicheFormGroup {
    const ficheRawValue = {
      ...this.getFormDefaults(),
      ...fiche,
    };
    return new FormGroup<FicheFormGroupContent>({
      id: new FormControl(
        { value: ficheRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      datemaj: new FormControl(ficheRawValue.datemaj, {
        validators: [Validators.required],
      }),
      type_observation: new FormControl(ficheRawValue.type_observation),
      identifiant_registre: new FormControl(ficheRawValue.identifiant_registre),
      date_enregistrement: new FormControl(ficheRawValue.date_enregistrement),
      sexe: new FormControl(ficheRawValue.sexe),
      date_naissance: new FormControl(ficheRawValue.date_naissance),
      statut: new FormControl(ficheRawValue.statut),
      date_deces: new FormControl(ficheRawValue.date_deces),
      circonstance_deces: new FormControl(ficheRawValue.circonstance_deces),
      autre_circonstance_deces: new FormControl(ficheRawValue.autre_circonstance_deces),
      lieu_deces: new FormControl(ficheRawValue.lieu_deces),
      consanguinite: new FormControl(ficheRawValue.consanguinite),
      origine_geo_pere_gouvernorat: new FormControl(ficheRawValue.origine_geo_pere_gouvernorat),
      origine_geo_mere_gouvernorat: new FormControl(ficheRawValue.origine_geo_mere_gouvernorat),
      origine_geo_pere_deleguation: new FormControl(ficheRawValue.origine_geo_pere_deleguation),
      origine_geo_mere_deleguation: new FormControl(ficheRawValue.origine_geo_mere_deleguation),
      couverture_sociale: new FormControl(ficheRawValue.couverture_sociale),
      autre_couverture_sociale: new FormControl(ficheRawValue.autre_couverture_sociale),
      activite: new FormControl(ficheRawValue.activite),
      btravail: new FormControl(ficheRawValue.btravail),
      travail: new FormControl(ficheRawValue.travail),
      scolarise: new FormControl(ficheRawValue.scolarise),
      type_scolarise: new FormControl(ficheRawValue.type_scolarise),
      niveau_scolarisation: new FormControl(ficheRawValue.niveau_scolarisation),
      pathologie: new FormControl(ficheRawValue.pathologie, {
        validators: [Validators.required],
      }),
    });
  }

  getFiche(form: FicheFormGroup): IFiche | NewFiche {
    return form.getRawValue() as IFiche | NewFiche;
  }

  resetForm(form: FicheFormGroup, fiche: FicheFormGroupInput): void {
    const ficheRawValue = { ...this.getFormDefaults(), ...fiche };
    form.reset(
      {
        ...ficheRawValue,
        id: { value: ficheRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): FicheFormDefaults {
    return {
      id: null,
      btravail: false,
      scolarise: false,
    };
  }
}
