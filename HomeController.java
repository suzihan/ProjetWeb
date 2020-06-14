package controllers;

import models.*;
import views.html.*;
import play.mvc.*;
import java.util.List ; 
import play.data.* ;
import javax.inject.Inject; 
import play.i18n.MessagesApi;

public class HomeController extends Controller {

    @Inject
    FormFactory formFactory; 
    Form<Personne> persoForm ;
    MessagesApi messagesApi;
    
    @Inject
    public HomeController(FormFactory formFactory, MessagesApi messagesApi) {
     this.persoForm = formFactory.form(Personne.class);
     this.messagesApi = messagesApi;
    }
    
    public Result login(){
        return ok(views.html.login.render());
    }
    
    public Result ajoutPerso(Http.Request request){
        return ok(views.html.ajoutPerso.render(persoForm,request,messagesApi.preferred(request)));
    }
    
    public Result persoOK(Http.Request request){
        Form<Personne> lform = persoForm.bindFromRequest(request);
        if(lform.hasErrors()){
            return badRequest(ajoutPerso.render(persoForm, request, messagesApi.preferred(request)));
        }else{
        Personne perso = lform.get();
            perso.save();
        return redirect(routes.HomeController.all());
        }
    }
    
    public Result all(){
        return ok(views.html.all.render());
    }
    
      public Result emprunter(){
        return ok(views.html.emprunter.render());
    }
    
       public Result lecture(){
        return ok(views.html.lecture.render());
    }
    
    public Result show(long id){
        Personne perso = Personne.find.byId(id);
        return ok(show.render(perso));
    }

    public Result delete(long id){
        Personne perso = Personne.find.byId(id);
        perso.delete();
        return redirect(routes.HomeController.all());
    }
    
    public Result update(long id, Http.Request request){
        Personne perso = Personne.find.byId(id);
        persoForm = persoForm.fill(perso);
        return ok(update.render(persoForm, id, request, messagesApi.preferred(request)));
    }
    
   public Result updateOK(Long id, Http.Request request){
        Form<Personne> lform = persoForm.bindFromRequest(request);
        if(lform.hasErrors()){
            return badRequest(ajoutPerso.render(persoForm, request, messagesApi.preferred(request)));
        }else{
        Personne perso = lform.get();
            perso.setID(id);
            perso.update();
        return redirect(routes.HomeController.all());
        }
    }
}
