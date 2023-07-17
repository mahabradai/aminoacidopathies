import dayjs from 'dayjs/esm';

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

import { IFiche, NewFiche } from './fiche.model';

export const sampleWithRequiredData: IFiche = {
  id: 52797,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithPartialData: IFiche = {
  id: 13668,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Colombian',
  date_enregistrement: dayjs('2023-07-15'),
  sexe: esexe['M'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['DECEDE'],
  date_deces: dayjs('2023-07-16'),
  consanguinite: econsanguinite['NON'],
  origine_geo_pere_deleguation: 'Investor',
  origine_geo_mere_deleguation: 'Account',
  autre_couverture_sociale: 'dynamic Steel',
  btravail: true,
  travail: 'Franc Table',
  cas_familiaux: ecasfamiliaux['OUI'],
  nbcassuspectes: 62399,
  nbcasdecedes: 78323,
};

export const sampleWithFullData: IFiche = {
  id: 20356,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Plastic North virtual',
  identifiant_registre: 'index CSS',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['INDETERMINE'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['DECEDE'],
  date_deces: dayjs('2023-07-16'),
  circonstance_deces: ecirconstance['NON_PRECISE'],
  autre_circonstance_deces: 'Ball',
  lieu_deces: elieudeces['DOMICILE'],
  consanguinite: econsanguinite['NP'],
  origine_geo_pere_gouvernorat: egouvernorat['MONASTIR'],
  origine_geo_mere_gouvernorat: egouvernoratmere['MEDENINE'],
  origine_geo_pere_deleguation: 'SCSI',
  origine_geo_mere_deleguation: 'Crossing',
  couverture_sociale: ecouverture['CNAM'],
  autre_couverture_sociale: 'Consultant Soft',
  activite: eactivite['OUI'],
  btravail: false,
  travail: 'Liberian Kentucky Awesome',
  scolarise: true,
  type_scolarise: escolarisetype['NP'],
  niveau_scolarisation: eniveauscolarisation['SUPERIEUR'],
  cas_familiaux: ecasfamiliaux['NON'],
  nbcasconfirme: 90424,
  nbcassuspectes: 92749,
  nbcasdecedes: 73824,
};

export const sampleWithNewData: NewFiche = {
  datemaj: dayjs('2023-07-16'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
