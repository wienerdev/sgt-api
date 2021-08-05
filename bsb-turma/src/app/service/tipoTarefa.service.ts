import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TipoTarefa} from '../model/tipoTarefa.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipoTarefaService {

  constructor(private http: HttpClient) { }

  salvarTipoTarefa(tipoTarefa: TipoTarefa): Observable<TipoTarefa> {
    return this.http.post<TipoTarefa>('http://localhost:8080/api/tipoTarefa', tipoTarefa);
  }
}
