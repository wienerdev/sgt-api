import {Component, OnInit} from "@angular/core";
import {Responsavel} from "../../../../model/responsavel.model";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ResponsavelService} from "../../../../service/responsavel.service";
import {ActivatedRoute,Router} from "@angular/router";
import {DropdownModel} from "../../../../model/dropdown.model";





@Component({
  selector: 'app-reponsavelAtualizar',
  templateUrl: './responsavel-atualizar.component.html',
  styleUrls: ['./responsavel-atualizar.component.css']
})
export class ResponsavelAtualizarComponent implements OnInit {


  responsaveis : DropdownModel[] = [];

  form : FormGroup;
  responsavel: Responsavel = {
    id: '',
    setor: ''
  }

  id = new FormControl('', [Validators.minLength(1)]);
  setor = new FormControl('', [Validators.minLength(4)]);

  constructor(
    private router: Router,
    private service: ResponsavelService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder) { }


  ngOnInit(): void {
    this.findAll();
    this.form = this.buildForm();
  }

  findAll(){
    this.service.findAllDropDown().subscribe((response)=>{
      alert("Buscou todos.");
      this.responsaveis = response;
    }, (error)=>{
      alert("Erro na requisição.");

    })
  }


  cancel(): void {
    this.router.navigate(['responsavel'])
  }

  buildForm(){
    return this.formBuilder.group({
      id: [null,[Validators.required]],
    }, {updateOn: 'change'});
  }

  update(): void {
    console.log(this.form.controls['id'].value)

    this.service.update(this.form.controls['id'].value)
    this.service.update(this.responsavel).subscribe((resposta) => {
    this.router.navigate([''])
    this.service.message('Responsavel atualizado com sucesso!')
    }, erro => {
      if (erro.error.error.match('já cadastrado')) {
        this.service.message(erro.error.error)
      }
    })
  }




  errorValidSetor() {
    if (this.setor.invalid) {
      return 'O nome deve ter entre 5 e 100 caracteres!';
    }
    return false;
  }

}
