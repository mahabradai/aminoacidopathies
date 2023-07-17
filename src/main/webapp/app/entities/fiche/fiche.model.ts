import dayjs from 'dayjs/esm';
import { IPathologie } from 'app/entities/pathologie/pathologie.model';
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

export interface IFiche {
  id: number;
  datemaj?: dayjs.Dayjs | null;
  type_observation?: string | null;
  identifiant_registre?: string | null;
  date_enregistrement?: dayjs.Dayjs | null;
  sexe?: esexe | null;
  date_naissance?: dayjs.Dayjs | null;
  statut?: estatut | null;
  date_deces?: dayjs.Dayjs | null;
  circonstance_deces?: ecirconstance | null;
  autre_circonstance_deces?: string | null;
  lieu_deces?: elieudeces | null;
  consanguinite?: econsanguinite | null;
  origine_geo_pere_gouvernorat?: egouvernorat | null;
  origine_geo_mere_gouvernorat?: egouvernoratmere | null;
  origine_geo_pere_deleguation?: string | null;
  origine_geo_mere_deleguation?: string | null;
  couverture_sociale?: ecouverture | null;
  autre_couverture_sociale?: string | null;
  activite?: eactivite | null;
  btravail?: boolean | null;
  travail?: string | null;
  scolarise?: boolean | null;
  type_scolarise?: escolarisetype | null;
  niveau_scolarisation?: eniveauscolarisation | null;
  pathologie?: Pick<IPathologie, 'id'> | null;
}

export type NewFiche = Omit<IFiche, 'id'> & { id: null };
