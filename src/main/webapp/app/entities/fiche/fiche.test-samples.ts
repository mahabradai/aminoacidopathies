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
import { ecircondecouverte } from 'app/entities/enumerations/ecircondecouverte.model';
import { eage_premier_symptome } from 'app/entities/enumerations/eage-premier-symptome.model';
import { eagepremiereconsultation } from 'app/entities/enumerations/eagepremiereconsultation.model';

import { IFiche, NewFiche } from './fiche.model';

export const sampleWithRequiredData: IFiche = {
  id: 52797,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithPartialData: IFiche = {
  id: 89638,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Generic copying encoding',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['M'],
  date_naissance: dayjs('2023-07-15'),
  statut: estatut['DECEDE'],
  date_deces: dayjs('2023-07-16'),
  consanguinite: econsanguinite['OUI'],
  origine_geo_pere_deleguation: 'Table orchid orchid',
  origine_geo_mere_deleguation: 'bricks-and-clicks',
  autre_couverture_sociale: 'Seamless Soft',
  btravail: true,
  travail: 'up',
  cas_familiaux: ecasfamiliaux['OUI'],
  nbcassuspectes: 34813,
  nbcasdecedes: 5105,
  age_aux_premiers_symptomes: eage_premier_symptome['CONNU'],
  jours_premiers_symptomes: 4937,
  an_age_premiere_consultation: 15184,
  date_derniere_evaluation: dayjs('2023-07-16'),
};

export const sampleWithFullData: IFiche = {
  id: 10538,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Nevada SCSI high-level',
  identifiant_registre: 'human-resource redundant',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['F'],
  date_naissance: dayjs('2023-07-15'),
  statut: estatut['DECEDE'],
  date_deces: dayjs('2023-07-16'),
  circonstance_deces: ecirconstance['NON_PRECISE'],
  autre_circonstance_deces: 'Awesome architecture',
  lieu_deces: elieudeces['DOMICILE'],
  consanguinite: econsanguinite['NP'],
  origine_geo_pere_gouvernorat: egouvernorat['TUNIS'],
  origine_geo_mere_gouvernorat: egouvernoratmere['TOZEUR'],
  origine_geo_pere_deleguation: 'Chief Fresh',
  origine_geo_mere_deleguation: 'HTTP',
  couverture_sociale: ecouverture['CNAM'],
  autre_couverture_sociale: 'Strategist ivory',
  activite: eactivite['NP'],
  btravail: false,
  travail: 'deposit Customer-focused',
  scolarise: true,
  type_scolarise: escolarisetype['AUTRE'],
  niveau_scolarisation: eniveauscolarisation['COLLEGE'],
  cas_familiaux: ecasfamiliaux['NP'],
  nbcasconfirme: 44195,
  nbcassuspectes: 31217,
  nbcasdecedes: 13213,
  deces_en_bas_age: edecesbasage['OUI'],
  nbcas_deces_age_bas: 35031,
  circonstances_decouverte: ecircondecouverte['ENQUETE_FAMILIALE'],
  age_aux_premiers_symptomes: eage_premier_symptome['CONNU'],
  an_age_premiers_symptomes: 82930,
  mois_age_premiers_symptomes: 20800,
  jours_premiers_symptomes: 32484,
  age_premiere_consultation: eagepremiereconsultation['CONNU'],
  an_age_premiere_consultation: 37933,
  mois_age_premiere_consultation: 2478,
  jours_premiere_consultation: 49841,
  date_derniere_evaluation: dayjs('2023-07-15'),
  date_diagnostic: dayjs('2023-07-16'),
};

export const sampleWithNewData: NewFiche = {
  datemaj: dayjs('2023-07-15'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
