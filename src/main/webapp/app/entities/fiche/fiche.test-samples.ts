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
import { edecesbasage } from 'app/entities/enumerations/edecesbasage.model';

import { IFiche, NewFiche } from './fiche.model';

export const sampleWithRequiredData: IFiche = {
  id: 52797,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithPartialData: IFiche = {
  id: 33046,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Unbranded',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['F'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['PERDU_DE_VUE'],
  date_deces: dayjs('2023-07-16'),
  consanguinite: econsanguinite['NP'],
  origine_geo_pere_deleguation: 'bandwidth revolutionize',
  origine_geo_mere_deleguation: 'encoding',
  autre_couverture_sociale: 'Pizza',
  btravail: true,
  travail: 'hacking',
  cas_familiaux: ecasfamiliaux['NON'],
  nbcassuspectes: 21363,
  nbcasdecedes: 62399,
};

export const sampleWithFullData: IFiche = {
  id: 78323,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Marketing drive',
  identifiant_registre: 'virtual',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['INDETERMINE'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['DECEDE'],
  date_deces: dayjs('2023-07-15'),
  circonstance_deces: ecirconstance['TBL_NEURO'],
  autre_circonstance_deces: 'Outdoors proactive Rustic',
  lieu_deces: elieudeces['STRUCTURE_SANTE_PUBLIQUE_NP'],
  consanguinite: econsanguinite['NON'],
  origine_geo_pere_gouvernorat: egouvernorat['MEDENINE'],
  origine_geo_mere_gouvernorat: egouvernoratmere['BIZERTE'],
  origine_geo_pere_deleguation: 'Central Crossing human-resource',
  origine_geo_mere_deleguation: 'platforms Loan synthesize',
  couverture_sociale: ecouverture['AUCUNE'],
  autre_couverture_sociale: 'granular California',
  activite: eactivite['OUI'],
  btravail: true,
  travail: 'Chief Fresh',
  scolarise: false,
  type_scolarise: escolarisetype['NP'],
  niveau_scolarisation: eniveauscolarisation['PRIMAIRE'],
  cas_familiaux: ecasfamiliaux['OUI'],
  nbcasconfirme: 30352,
  nbcassuspectes: 53207,
  nbcasdecedes: 96481,
  deces_en_bas_age: edecesbasage['NP'],
  nbcas_deces_age_bas: 68867,
};

export const sampleWithNewData: NewFiche = {
  datemaj: dayjs('2023-07-16'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
