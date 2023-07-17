import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'structuresante',
        data: { pageTitle: 'Structuresantes' },
        loadChildren: () => import('./structuresante/structuresante.module').then(m => m.StructuresanteModule),
      },
      {
        path: 'etablissement',
        data: { pageTitle: 'Etablissements' },
        loadChildren: () => import('./etablissement/etablissement.module').then(m => m.EtablissementModule),
      },
      {
        path: 'servicesante',
        data: { pageTitle: 'Servicesantes' },
        loadChildren: () => import('./servicesante/servicesante.module').then(m => m.ServicesanteModule),
      },
      {
        path: 'medecin',
        data: { pageTitle: 'Medecins' },
        loadChildren: () => import('./medecin/medecin.module').then(m => m.MedecinModule),
      },
      {
        path: 'pathologie',
        data: { pageTitle: 'Pathologies' },
        loadChildren: () => import('./pathologie/pathologie.module').then(m => m.PathologieModule),
      },
      {
        path: 'fiche',
        data: { pageTitle: 'Fiches' },
        loadChildren: () => import('./fiche/fiche.module').then(m => m.FicheModule),
      },
      {
        path: 'structurefiche',
        data: { pageTitle: 'Structurefiches' },
        loadChildren: () => import('./structurefiche/structurefiche.module').then(m => m.StructureficheModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
