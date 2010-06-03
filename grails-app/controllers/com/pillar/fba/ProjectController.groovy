package com.pillar.fba

class ProjectController {

    def scaffold = {}
    def copy = {
        def project = new Project(params)
        project.save();
        redirect(action:list)
    }

}