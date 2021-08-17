import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from "../../environments/environment";
import {MatSnackBar} from "@angular/material/snack-bar";
import {DropdownModel} from "../model/dropdown.model";
import {TipoTarefa} from "../model/tipoTarefa.model";

@Injectable({
  providedIn: 'root'
})
export class TarefaService {


  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private snack: MatSnackBar) {
  }


  encontrarPorId(id: any): Observable<TipoTarefa> {
    const url = '${this.baseUrl}/api/tipoTarefa/${id}';
    return this.http.get<TipoTarefa>(url);
  }


  listar(): Observable<TipoTarefa[]> {
    const url = this.baseUrl + "/api/tipoTarefa";
    return this.http.get<TipoTarefa[]>(url);
  }

  salvar(tipoTarefa: TipoTarefa): Observable<TipoTarefa> {
    const url = this.baseUrl + "/api/tipoTarefa";
    return this.http.post<TipoTarefa>(url, tipoTarefa);
  }

  update(tipoTarefa: TipoTarefa, id: any): Observable<TipoTarefa> {
    const url = this.baseUrl + "/api/tipoTarefa/" + id;
    return this.http.put<TipoTarefa>(url, tipoTarefa);
  }

  deletar(id: any): Observable<void> {
    const url = `${this.baseUrl}/api/tipoTarefa/${id}`;
    return this.http.delete<void>(url);
  }

  findAllDropDown(): Observable<DropdownModel[]> {
    return this.http.get<DropdownModel[]>(`${this.baseUrl}/api/tipoTarefa/select`);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }

}

