package com.pillar.fba

class ProjectController {

    def scaffold = {}
    def copy = {
        def project = new Project(params)
        project.save();
        redirect(action:list)
    }
    
    def save = {
        def project = new Project(params)
        if(!project.hasErrors() && project.save()) {
            redirect(action:edit,id:project.id)
        } else {
            render(view:'create',model:[project:project])
        }
    }

}