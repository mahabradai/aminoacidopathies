import dayjs from 'dayjs/esm';

import { IFiche, NewFiche } from './fiche.model';

export const sampleWithRequiredData: IFiche = {
  id: 52797,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithPartialData: IFiche = {
  id: 84643,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithFullData: IFiche = {
  id: 75942,
  datemaj: dayjs('2023-07-16'),
};

export const sampleWithNewData: NewFiche = {
  datemaj: dayjs('2023-07-16'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
