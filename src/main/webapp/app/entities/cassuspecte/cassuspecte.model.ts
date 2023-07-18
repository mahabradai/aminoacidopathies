import { elienparente } from 'app/entities/enumerations/elienparente.model';

export interface ICassuspecte {
  id: number;
  lienparente?: elienparente | null;
  lienparenteautre?: string | null;
  signes_neurologiques?: boolean | null;
  troubles_de_la_conscience?: boolean | null;
  retard_psychomoteur?: boolean | null;
  retard_mental?: boolean | null;
  signes_du_spectre_autistique?: boolean | null;
  epilepsie?: boolean | null;
  crise_pseudoporphyrique?: boolean | null;
  autres_signes_neurologiques?: string | null;
  signes_hepatiques?: boolean | null;
  ictere?: boolean | null;
  ballonnement?: boolean | null;
  syndrome_hemorragique?: boolean | null;
  autres_signes_hepatiques?: string | null;
}

export type NewCassuspecte = Omit<ICassuspecte, 'id'> & { id: null };
