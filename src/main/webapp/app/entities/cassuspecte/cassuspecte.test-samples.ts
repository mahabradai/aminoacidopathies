import { elienparente } from 'app/entities/enumerations/elienparente.model';

import { ICassuspecte, NewCassuspecte } from './cassuspecte.model';

export const sampleWithRequiredData: ICassuspecte = {
  id: 90725,
};

export const sampleWithPartialData: ICassuspecte = {
  id: 82398,
  lienparente: elienparente['FRERE_SOEUR'],
  troubles_de_la_conscience: false,
  retard_psychomoteur: false,
  retard_mental: true,
  signes_du_spectre_autistique: true,
  epilepsie: false,
  crise_pseudoporphyrique: true,
  autres_signes_neurologiques: 'Corporate program',
  signes_hepatiques: false,
  ballonnement: true,
  syndrome_hemorragique: false,
  autres_signes_hepatiques: 'Table invoice invoice',
};

export const sampleWithFullData: ICassuspecte = {
  id: 16066,
  lienparente: elienparente['COUSIN_COUSINE'],
  lienparenteautre: 'Shoes Representative',
  signes_neurologiques: true,
  troubles_de_la_conscience: false,
  retard_psychomoteur: false,
  retard_mental: true,
  signes_du_spectre_autistique: true,
  epilepsie: false,
  crise_pseudoporphyrique: true,
  autres_signes_neurologiques: 'copy Steel',
  signes_hepatiques: true,
  ictere: true,
  ballonnement: true,
  syndrome_hemorragique: true,
  autres_signes_hepatiques: 'Shoes',
};

export const sampleWithNewData: NewCassuspecte = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
