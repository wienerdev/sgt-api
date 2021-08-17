import {Component, OnInit} from "@angular/core";
import {Responsavel} from "../../../../model/responsavel.model";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ResponsavelService} from "../../../../service/responsavel.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DropdownModel} from "../../../../model/dropdown.model";
import validate = WebAssembly.validate;


@Component({
  selector: 'app-reponsavelDeletar',
  templateUrl: './responsavel-deletar.component.html',
  styleUrls: ['./responsavel-deletar.component.css']
})
export class ResponsavelDeletarComponent implements OnInit {


  responsaveis : DropdownModel[] = [];

  form : FormGroup;


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

  deletar(): void {
    console.log(this.form.controls['id'].value)
   this.service.deletar(this.form.controls['id'].value).subscribe((resposta) => {
   this.router.navigate(['responsavel'])
   this.service.message('Responsavel excluído com sucesso!')
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


}
