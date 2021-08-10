import {Component,EventEmitter, Input, OnInit, Output} from "@angular/core";
import {TipoTarefa} from '../../../model/tipoTarefa.model';
import {TipoTarefaService} from "../../../service/tipoTarefa.service";



@Component({
    selector: 'app-tipoTarefa-crud',
    templateUrl: './tipoTarefa-crud.component.html',
    styleUrls: [ './tipoTarefa-crud.component.css']
})
export class TipoTarefaCrudComponent implements OnInit {
    @Output() criarTipoTarefa = new EventEmitter<TipoTarefa>();
    @Input() descricaoTipoTarefaForm: string;
    tipoTarefa: TipoTarefa = new TipoTarefa();
    constructor(private tipoTarefaService: TipoTarefaService) {}
    ngOnInit(): void {
    }
    click(): void {
        this.tipoTarefaService.salvarTipoTarefa(this.tipoTarefa)
            .subscribe( retorno => this.criarTipoTarefa.emit(retorno));    }
}
