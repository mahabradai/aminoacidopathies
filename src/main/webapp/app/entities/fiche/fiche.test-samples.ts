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
import { ehandicapmental } from 'app/entities/enumerations/ehandicapmental.model';
import { eQI } from 'app/entities/enumerations/e-qi.model';
import { eMoteur } from 'app/entities/enumerations/e-moteur.model';
import { egrade } from 'app/entities/enumerations/egrade.model';
import { edeficitneuro } from 'app/entities/enumerations/edeficitneuro.model';
import { edeficitneurosensorielval } from 'app/entities/enumerations/edeficitneurosensorielval.model';
import { edeficiencepsychique } from 'app/entities/enumerations/edeficiencepsychique.model';
import { edeficiencepsychiqueval } from 'app/entities/enumerations/edeficiencepsychiqueval.model';
import { eregime } from 'app/entities/enumerations/eregime.model';
import { eregimeval } from 'app/entities/enumerations/eregimeval.model';

import { IFiche, NewFiche } from './fiche.model';

export const sampleWithRequiredData: IFiche = {
  id: 52797,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithPartialData: IFiche = {
  id: 12049,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'AI',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['INDETERMINE'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['DECEDE'],
  date_deces: dayjs('2023-07-16'),
  consanguinite: econsanguinite['OUI'],
  origine_geo_pere_deleguation: 'digital Marketing',
  origine_geo_mere_deleguation: 'North virtual invoice',
  autre_couverture_sociale: 'CSS Outdoors',
  btravail: false,
  travail: 'auxiliary',
  cas_familiaux: ecasfamiliaux['OUI'],
  nbcassuspectes: 10538,
  nbcasdecedes: 26940,
  age_aux_premiers_symptomes: eage_premier_symptome['CONNU'],
  jours_premiers_symptomes: 58564,
  an_age_premiere_consultation: 55340,
  date_derniere_evaluation: dayjs('2023-07-16'),
  handicap_mental: ehandicapmental['NON'],
  qi: eQI['INFERIEUR_20'],
  handicap_moteur: eMoteur['NON'],
  deficit_neurosensoriel: edeficitneuro['NON'],
  deficience_psychique: edeficiencepsychique['NON'],
};

export const sampleWithFullData: IFiche = {
  id: 13996,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Cambridgeshire',
  identifiant_registre: 'Soft Division',
  date_enregistrement: dayjs('2023-07-16'),
  sexe: esexe['F'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['PERDU_DE_VUE'],
  date_deces: dayjs('2023-07-16'),
  circonstance_deces: ecirconstance['TBL_HEMORRAGIQUE'],
  autre_circonstance_deces: 'California',
  lieu_deces: elieudeces['STRUCTURE_SANTE_PUBLIQUE_NP'],
  consanguinite: econsanguinite['NP'],
  origine_geo_pere_gouvernorat: egouvernorat['KEF'],
  origine_geo_mere_gouvernorat: egouvernoratmere['TUNIS'],
  origine_geo_pere_deleguation: 'panel Creek Hat',
  origine_geo_mere_deleguation: 'Convertible Wooden Borders',
  couverture_sociale: ecouverture['CNAM'],
  autre_couverture_sociale: 'Metal',
  activite: eactivite['NA'],
  btravail: false,
  travail: 'e-services Plastic neural',
  scolarise: false,
  type_scolarise: escolarisetype['AUTRE'],
  niveau_scolarisation: eniveauscolarisation['COLLEGE'],
  cas_familiaux: ecasfamiliaux['OUI'],
  nbcasconfirme: 49841,
  nbcassuspectes: 88106,
  nbcasdecedes: 50580,
  deces_en_bas_age: edecesbasage['NP'],
  nbcas_deces_age_bas: 96314,
  circonstances_decouverte: ecircondecouverte['SYMPTOMATIQUE'],
  age_aux_premiers_symptomes: eage_premier_symptome['CONNU'],
  an_age_premiers_symptomes: 13857,
  mois_age_premiers_symptomes: 30049,
  jours_premiers_symptomes: 62659,
  age_premiere_consultation: eagepremiereconsultation['CONNU'],
  an_age_premiere_consultation: 10065,
  mois_age_premiere_consultation: 83827,
  jours_premiere_consultation: 35980,
  date_derniere_evaluation: dayjs('2023-07-16'),
  date_diagnostic: dayjs('2023-07-16'),
  handicap_mental: ehandicapmental['OUI'],
  qi: eQI['QI_20_34'],
  handicap_moteur: eMoteur['NP'],
  hadicap_moteur_grade: egrade['MOYEN'],
  deficit_neurosensoriel: edeficitneuro['NON'],
  deficit_neurosensoriel_val: edeficitneurosensorielval['VISUEL'],
  deficience_psychique: edeficiencepsychique['OUI'],
  deficience_psychique_val: edeficiencepsychiqueval['TROUBLES_HUMEUR'],
  autre_deficience_psychique: 'Maryland one-to-one maximize',
  regime: eregime['NON'],
  regime_val: eregimeval['NP'],
};

export const sampleWithNewData: NewFiche = {
  datemaj: dayjs('2023-07-16'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
