import dayjs from 'dayjs/esm';
import { IPathologie } from 'app/entities/pathologie/pathologie.model';

export interface IFiche {
  id: number;
  datemaj?: dayjs.Dayjs | null;
  pathologie?: Pick<IPathologie, 'id'> | null;
}

export type NewFiche = Omit<IFiche, 'id'> & { id: null };
