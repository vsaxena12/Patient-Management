import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Patient {
  id?: number;
  firstName: string;
  lastName: string;
  email: string;
  address: string;
  dateOfBirth: string;
  dateOfAdmit: string;
  dateOfDischarge: string;
}

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private readonly baseUrl = 'http://localhost:8080/api/patients';

  constructor(private http: HttpClient) { }

  getAllPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.baseUrl);
  }
}