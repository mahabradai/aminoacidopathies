import { elienparente } from 'app/entities/enumerations/elienparente.model';

import { ICassuspecte, NewCassuspecte } from './cassuspecte.model';

export const sampleWithRequiredData: ICassuspecte = {
  id: 90725,
};

export const sampleWithPartialData: ICassuspecte = {
  id: 85867,
  lienparente: elienparente['NP'],
  troubles_de_la_conscience: false,
  retard_psychomoteur: true,
  retard_mental: false,
  signes_du_spectre_autistique: true,
  epilepsie: false,
  crise_pseudoporphyrique: false,
  autres_signes_neurologiques: 'invoice',
  signes_hepatiques: true,
  ballonnement: true,
  syndrome_hemorragique: true,
  autres_signes_hepatiques: 'withdrawal',
  signes_osseux: true,
  cerebrale: true,
  autre_manifestations_thrombotiques: 'Metrics Steel Coordinator',
  luxation: false,
  ectopie_cristalinienne: true,
  cataracte: false,
  manifestations_ophtalmologiques_autre: 'Steel matrix Florida',
};

export const sampleWithFullData: ICassuspecte = {
  id: 49630,
  lienparente: elienparente['COUSIN_COUSINE'],
  lienparenteautre: 'red flexibility paradigms',
  signes_neurologiques: true,
  troubles_de_la_conscience: true,
  retard_psychomoteur: true,
  retard_mental: true,
  signes_du_spectre_autistique: true,
  epilepsie: false,
  crise_pseudoporphyrique: false,
  autres_signes_neurologiques: 'Granite olive copying',
  signes_hepatiques: true,
  ictere: false,
  ballonnement: true,
  syndrome_hemorragique: false,
  autres_signes_hepatiques: 'Argentine',
  signes_osseux: true,
  signes_de_rachitisme: false,
  autre_signes_osseux: 'indexing',
  manifestations_thrombotiques: false,
  cerebrale: true,
  autre_manifestations_thrombotiques: 'Republic Response systems',
  manifestations_ophtalmologiques: true,
  luxation: true,
  ectopie_cristalinienne: false,
  cataracte: true,
  glaucome: false,
  myopie: false,
  manifestations_ophtalmologiques_autre: 'Vermont Somoni',
};

export const sampleWithNewData: NewCassuspecte = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
