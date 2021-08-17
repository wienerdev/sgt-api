import {Component,EventEmitter, Input, OnInit, Output} from "@angular/core";
import {Comentario} from "../../../../model/comentario.model";
import {ComentarioService} from "../../../../service/comentario.service";
@Component({
    selector: 'app-comentario-crud',
    templateUrl: './comentario-listar.component.html',
    styleUrls: [ './comentario-listar.component.css']
})
export class ComentarioListarComponent implements OnInit {
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
