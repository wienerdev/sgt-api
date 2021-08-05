import {Component,EventEmitter, Input, OnInit, Output} from "@angular/core";

import {ResponsavelService} from "../service/responsavel.service";
import {Responsavel} from "../model/responsavel.model";


@Component({
    selector: 'app-responsavel-crud',
    templateUrl: './responsavel-crud.component.html',
    styleUrls: [ './responsavel-crud.component.css']
})
export class ResponsavelCrudComponent implements OnInit {
    @Output() criarResponsavel = new EventEmitter<Responsavel>();
    @Input() setorForm: string;
    responsavel: Responsavel = new Responsavel();
    constructor(private responsavelService: ResponsavelService) {}
    ngOnInit(): void {
    }
    click(): void {
        this.responsavelService.salvarResponsavel(this.responsavel)
            .subscribe( retorno => this.criarResponsavel.emit(retorno));    }
}
