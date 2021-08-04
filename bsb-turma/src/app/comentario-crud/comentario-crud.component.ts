import {Component,EventEmitter, Input, OnInit, Output} from "@angular/core";
import {Comentario} from "../model/comentario.model";


@Component({
  selector: 'app-comentario-crud',
    templateUrl: './comentario-crud.component.html',
    styleUrls: [ './comentario-crud.component.css']

})

export class ComentarioCrudComponent implements OnInit {

    @Output() criarComentario = new EventEmitter<Comentario>();

    @Input() descricaoForm: string;

    comentario: Comentario = new Comentario();

    constructor(private comentarioService: ComentarioService) {}

    ngOnInit(): void {

    }

    click(): void {
        this.comentar.Service.salvarComentario(this.comentario)
            .subscribe( retorno => this.criarComentario.omit(retorno));    }



}
