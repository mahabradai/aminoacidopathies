import { IFiche } from 'app/entities/fiche/fiche.model';
import { elien_parente } from 'app/entities/enumerations/elien-parente.model';

export interface ICasconfirme {
  id: number;
  code_registre?: string | null;
  lien_parente?: elien_parente | null;
  fiche: IFiche; //  relation ManyToOne
}

export type NewCasconfirme = Omit<ICasconfirme, 'id'> & { id: null };
