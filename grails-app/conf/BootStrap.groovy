import com.pillar.fba.*;

class BootStrap {

     def init = { servletContext ->
	Client gale = new Client(name:"Gale Cengage",abbr:"GALE").save();
	Client dominos = new Client(name:"Dominos",abbr:"DOMI").save();
	Resource jarred = new Resource(name:"Jarred",startDate:new Date(), endDate:new Date(), loadedHourlyCost:50).save();
	Resource zach = new Resource(name:"Zach",startDate:new Date(), endDate:new Date(), loadedHourlyCost:55).save();
	Resource rich = new Resource(name:"Rich",startDate:new Date(), endDate:new Date(), loadedHourlyCost:5500).save();
	Resource matt = new Resource(name:"Matt Van Vleet",startDate:new Date(), endDate:new Date(), loadedHourlyCost:5).save();
	Resource mattLeForrest = new Resource(name:"Matt",startDate:new Date(), endDate:new Date(), loadedHourlyCost:60).save();
	Resource amber = new Resource(name:"Amber",startDate:new Date(), endDate:new Date(), loadedHourlyCost:65).save();
     }
     def destroy = {
     }
} 