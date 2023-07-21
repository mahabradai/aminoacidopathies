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
import { emedicamentspecifique } from 'app/entities/enumerations/emedicamentspecifique.model';
import { emedicamentspecifiqueval } from 'app/entities/enumerations/emedicamentspecifiqueval.model';
import { evitamines } from 'app/entities/enumerations/evitamines.model';
import { evitamineval } from 'app/entities/enumerations/evitamineval.model';
import { egreffehepatique } from 'app/entities/enumerations/egreffehepatique.model';
import { erededucationfonctionnelle } from 'app/entities/enumerations/erededucationfonctionnelle.model';

import { IFiche, NewFiche } from './fiche.model';

export const sampleWithRequiredData: IFiche = {
  id: 52797,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithPartialData: IFiche = {
  id: 82297,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Bedfordshire digital',
  date_enregistrement: dayjs('2023-07-15'),
  sexe: esexe['M'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['PERDU_DE_VUE'],
  date_deces: dayjs('2023-07-16'),
  consanguinite: econsanguinite['NON'],
  origine_geo_pere_deleguation: 'virtual',
  origine_geo_mere_deleguation: 'index CSS',
  autre_couverture_sociale: 'CSS',
  btravail: false,
  travail: 'Rustic Intranet Pizza',
  cas_familiaux: ecasfamiliaux['NON'],
  nbcassuspectes: 26618,
  nbcasdecedes: 46355,
  age_aux_premiers_symptomes: eage_premier_symptome['NON_CONNU'],
  jours_premiers_symptomes: 44162,
  an_age_premiere_consultation: 26951,
  date_derniere_evaluation: dayjs('2023-07-16'),
  handicap_mental: ehandicapmental['NON'],
  qi: eQI['QI_20_34'],
  handicap_moteur: eMoteur['NON'],
  deficit_neurosensoriel: edeficitneuro['NON'],
  deficience_psychique: edeficiencepsychique['NP'],
  vitamines: evitamines['NON'],
  greffehepatique: egreffehepatique['NP'],
};

export const sampleWithFullData: IFiche = {
  id: 45265,
  datemaj: dayjs('2023-07-16'),
  type_observation: 'Cliff granular California',
  identifiant_registre: 'ADP Mobility RSS',
  date_enregistrement: dayjs('2023-07-15'),
  sexe: esexe['M'],
  date_naissance: dayjs('2023-07-16'),
  statut: estatut['DECEDE'],
  date_deces: dayjs('2023-07-16'),
  circonstance_deces: ecirconstance['AUTRE'],
  autre_circonstance_deces: 'Convertible Wooden Borders',
  lieu_deces: elieudeces['DOMICILE'],
  consanguinite: econsanguinite['OUI'],
  origine_geo_pere_gouvernorat: egouvernorat['BIZERTE'],
  origine_geo_mere_gouvernorat: egouvernoratmere['SFAX'],
  origine_geo_pere_deleguation: 'withdrawal e-services',
  origine_geo_mere_deleguation: 'best-of-breed',
  couverture_sociale: ecouverture['REGIME_MILITAIRE'],
  autre_couverture_sociale: 'model',
  activite: eactivite['NP'],
  btravail: false,
  travail: 'Cambridgeshire Wooden bandwidth',
  scolarise: false,
  type_scolarise: escolarisetype['ECOLE_INTEGRATION'],
  niveau_scolarisation: eniveauscolarisation['SECONDAIRE'],
  cas_familiaux: ecasfamiliaux['NON'],
  nbcasconfirme: 73966,
  nbcassuspectes: 28330,
  nbcasdecedes: 40699,
  deces_en_bas_age: edecesbasage['OUI'],
  nbcas_deces_age_bas: 50276,
  circonstances_decouverte: ecircondecouverte['SYMPTOMATIQUE'],
  age_aux_premiers_symptomes: eage_premier_symptome['NON_CONNU'],
  an_age_premiers_symptomes: 80039,
  mois_age_premiers_symptomes: 56362,
  jours_premiers_symptomes: 38707,
  age_premiere_consultation: eagepremiereconsultation['NON_CONNU'],
  an_age_premiere_consultation: 33966,
  mois_age_premiere_consultation: 21809,
  jours_premiere_consultation: 13428,
  date_derniere_evaluation: dayjs('2023-07-16'),
  date_diagnostic: dayjs('2023-07-16'),
  handicap_mental: ehandicapmental['OUI'],
  qi: eQI['QI_35_49'],
  handicap_moteur: eMoteur['OUI'],
  hadicap_moteur_grade: egrade['GRAND'],
  deficit_neurosensoriel: edeficitneuro['NON'],
  deficit_neurosensoriel_val: edeficitneurosensorielval['NP'],
  deficience_psychique: edeficiencepsychique['OUI'],
  deficience_psychique_val: edeficiencepsychiqueval['TROUBLES_COMPORTEMENT'],
  autre_deficience_psychique: 'Maryland models Steel',
  regime: eregime['NP'],
  regime_val: eregimeval['HYPOPROTIDIQUE'],
  medicament_specifique: emedicamentspecifique['NON'],
  medicament_specifique_val: emedicamentspecifiqueval['NTBC_NITISIN_ORFADIN'],
  autre_medicament_specifique: 'networks Forint model',
  vitamines: evitamines['NP'],
  vitamines_val: evitamineval['NP'],
  greffehepatique: egreffehepatique['NON'],
  reeducation_fonctionnelle: erededucationfonctionnelle['NON'],
};

export const sampleWithNewData: NewFiche = {
  datemaj: dayjs('2023-07-15'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
