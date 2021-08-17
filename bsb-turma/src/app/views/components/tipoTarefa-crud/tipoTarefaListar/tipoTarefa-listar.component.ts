import {AfterViewInit, Component, ViewChild} from "@angular/core";
import {TipoTarefa} from '../../../../model/tipoTarefa.model';
import {TipoTarefaService} from "../../../../service/tipoTarefa.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {Router} from "@angular/router";


@Component({
  selector: 'app-tipoTarefaListar',
  templateUrl: './tipoTarefa-listar.component.html',
  styleUrls: ['./tipoTarefa-listar.component.css']
})


export class TipoTarefaListarComponent implements AfterViewInit {

  tipoTarefa: TipoTarefa[] = [];


  displayedColumns: string[] = ['id', 'descricaoTipoTarefa'];
  dataSource = new MatTableDataSource<TipoTarefa>(this.tipoTarefa);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private service: TipoTarefaService, private router : Router)  { }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.listar();
  }


  listar(): void {
    this.service.listar().subscribe((resposta) => {
      this.tipoTarefa = resposta;
      console.log(this.tipoTarefa)
      this.dataSource = new MatTableDataSource<TipoTarefa>(this.tipoTarefa);
      this.dataSource.paginator = this.paginator;
    })
  }

  navigateToSalvar():void{
    this.router.navigate(['tipotarefas/salvar'])
  }

  navigateToDeletar() {
    this.router.navigate(['tipotarefas/delete'])
  }

  navigateToUpdate() {
    this.router.navigate(['tipotarefas/update'])
  }

}


