import {Component, OnInit} from "@angular/core";

import {DropdownModel} from "../../../../model/dropdown.model";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {TarefaService} from "../../../../service/tarefa.service";
import {Tarefa} from "../../../../model/tarefa.model";


@Component({
  selector: 'app-tarefa-crud',
  templateUrl: './tarefa-atualizar.component.html',
  styleUrls: [ './tarefa-atualizar.component.css']
})
export class TarefaAtualizarComponent implements OnInit {

  tarefas: DropdownModel[] = [];

  form: FormGroup;
  tarefa: Tarefa = {
    id: '',
    descricao: '',
    status:'',
    titulo:''
  }

  id = new FormControl(1, [Validators.minLength(1)]);
  //id: number = 13;
  descricao = new FormControl('', [Validators.minLength(4)]);

  titulo = new FormControl('', [Validators.minLength(4)]);

  status = new FormControl('', [Validators.minLength(4)]);


  constructor(
    private router: Router,
    private service: TarefaService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder) {
  }


  ngOnInit(): void {
    this.findAll();
    this.form = this.buildForm();
  }

  findAll() {
    this.service.findAllDropDown().subscribe((response) => {
      alert("Buscou todos.");
      console.log(response);
      this.tarefas = response;
      console.log(this.tarefas);
    }, (error) => {
      alert("Erro na requisição.");

    })
  }

  cancel(): void {
    this.router.navigate(['tarefas'])
  }

  buildForm() {
    return this.formBuilder.group({
      id: [null, [Validators.required]],
    }, {updateOn: 'change'});
  }

  update(): void {
    // console.log(this.id.value);

    console.log(this['id'].value)
    this.service.update(this.tarefa, this['id'].value).subscribe((resposta) => {
      this.router.navigate(['tarefas'])
      this.service.message('Responsavel atualizado com sucesso!')
    })
  }

  errorValidDescricao() {
    if (this.descricao.invalid) {
      return 'O nome deve ter entre 5 e 100 caracteres!';
    }
    return false;
  }

}
