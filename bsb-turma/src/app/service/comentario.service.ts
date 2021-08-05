import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Comentario} from "../model/comentario.model";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ComentarioService {

  constructor(private http: HttpClient) { }

  salvarComentario(comentario: Comentario): Observable<Comentario> {
    return this.http.post<Comentario>( 'http://localhost:8080/api/comentarios', comentario);
  }
}
