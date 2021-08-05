import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs';
import {Responsavel} from "../model/responsavel.model";

@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  constructor(private http: HttpClient) { }

  salvarResponsavel(responsavel: Responsavel): Observable<Responsavel> {
    return this.http.post<Responsavel>('http://localhost:8080/api/responsavel', responsavel);
  }
}
