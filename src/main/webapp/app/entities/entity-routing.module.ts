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
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
