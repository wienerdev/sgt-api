import {Component, OnInit} from "@angular/core";
import {DropdownModel} from "../../../../model/dropdown.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {TarefaService} from "../../../../service/tarefa.service";


@Component({
  selector: 'app-tarefa-crud',
  templateUrl: './tarefa-deletar.component.html',
  styleUrls: [ './tarefa-deletar.component.css']
})
export class TarefaDeletarComponent implements OnInit {

  tarefas : DropdownModel[] = [];

  form : FormGroup;


  constructor(
    private router: Router,
    private service: TarefaService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder) { }


  ngOnInit(): void {
    this.findAll();
    this.form = this.buildForm();
  }

  findAll(){
    this.service.findAllDropDown().subscribe((response)=>{
      alert("Buscou todos.");
      this.tarefas = response;
    }, (error)=>{
      alert("Erro na requisição.");

    })
  }

  deletar(): void {
    console.log(this.form.controls['id'].value)
    this.service.deletar(this.form.controls['id'].value).subscribe((resposta) => {
      this.router.navigate(['tarefas'])
      this.service.message('Tipo de Tarefa excluído com sucesso!')
    })
  }

  cancel(): void {
    this.router.navigate(['tarefas'])
  }

  buildForm(){
    return this.formBuilder.group({
      id: [null,[Validators.required]],
    }, {updateOn: 'change'});
  }


}
