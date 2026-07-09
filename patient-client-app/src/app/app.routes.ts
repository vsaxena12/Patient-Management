import { Routes } from '@angular/router';
import { PatientListComponent } from './patients/patient-list/patient-list.component';
import { AddPatientComponent } from './patients/add-patient/add-patient.component';
import { UpdatePatientComponent } from './patients/update-patient/update-patient.component';
import { PatientDetailsComponent } from './patients/patient-details/patient-details.component';

export const routes: Routes = [
    { path: '', redirectTo: 'patients', pathMatch: 'full' },
    { path: 'patients', component: PatientListComponent },
    { path: 'patients/add', component: AddPatientComponent },
    { path: 'patients/update/:id', component: UpdatePatientComponent },
    { path: 'patients/view/:id', component: PatientDetailsComponent }
];