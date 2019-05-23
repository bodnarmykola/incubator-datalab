/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

 import { Component, OnInit } from '@angular/core';
 import { ToastrService } from 'ngx-toastr';
 import { MatTableDataSource } from '@angular/material';

 import { ProjectDataService } from '../project-data.service';
 import { ProjectService } from '../../../core/services';
 import { Project } from '../project.component';

@Component({
  selector: 'project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.scss']
})
export class ProjectListComponent implements OnInit {

  displayedColumns: string[] = ['project_name', 'endpoints_list', 'project_tag', 'actions'];
  dataSource: Project[] | any;

  constructor(
    public toastr: ToastrService,
    private projectDataService: ProjectDataService,
    private projectService: ProjectService
    ) { }


  ngOnInit() {
    this.getProjectsList();
  }

  public editProject(item: Project[]) {
    debugger;
  }
  
  public deleteProject(item: Project[]) {
    debugger;
  }

  private getProjectsList() {
    // Project[] type
    debugger;
    this.dataSource = new MatTableDataSource(this.projectDataService.getProjects)
  }
}
