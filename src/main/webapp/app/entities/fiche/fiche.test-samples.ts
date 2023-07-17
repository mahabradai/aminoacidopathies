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

import { IFiche, NewFiche } from './fiche.model';

export const sampleWithRequiredData: IFiche = {
  id: 52797,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithPartialData: IFiche = {
  id: 94097,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'back-end open Unbranded',
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
};

export const sampleWithFullData: IFiche = {
  id: 49002,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'digital Marketing',
  identifiant_registre: 'North virtual invoice',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['INDETERMINE'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['INTERRUPTION_DE_GROSSESSE'],
  date_deces: dayjs('2023-07-16'),
  circonstance_deces: ecirconstance['AUTRE'],
  autre_circonstance_deces: 'proactive',
  lieu_deces: elieudeces['DOMICILE'],
  consanguinite: econsanguinite['OUI'],
  origine_geo_pere_gouvernorat: egouvernorat['JENDOUBA'],
  origine_geo_mere_gouvernorat: egouvernoratmere['BENAROUS'],
  origine_geo_pere_deleguation: 'Intranet',
  origine_geo_mere_deleguation: 'SCSI',
  couverture_sociale: ecouverture['CNAM'],
  autre_couverture_sociale: 'Cotton Cambridgeshire',
  activite: eactivite['NON'],
  btravail: false,
  travail: 'Loan synthesize Awesome',
  scolarise: false,
  type_scolarise: escolarisetype['ECOLE_NORMALE'],
  niveau_scolarisation: eniveauscolarisation['SECONDAIRE'],
};

export const sampleWithNewData: NewFiche = {
  datemaj: dayjs('2023-07-16'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
