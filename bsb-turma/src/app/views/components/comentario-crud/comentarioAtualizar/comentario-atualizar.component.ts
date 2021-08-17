import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";
import {Comentario} from "../../../../model/comentario.model";
import {ComentarioService} from "../../../../service/comentario.service";

@Component({
    selector: 'app-comentario-crud',
    templateUrl: './comentario-atualizar.component.html',
    styleUrls: [ './comentario-atualizar.component.css']
})
export class ComentarioAtualizarComponent implements OnInit {
    @Output() criarComentario = new EventEmitter<Comentario>();
    @Input() descricaoForm: string;
    comentario: Comentario = new Comentario();
    constructor(private comentarioService: ComentarioService) {}
    ngOnInit(): void {
    }
    click(): void {
        this.comentarioService.salvar(this.comentario)
            .subscribe( retorno => this.criarComentario.emit(retorno));    }
}
