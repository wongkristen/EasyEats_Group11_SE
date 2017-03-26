angular
  .module('mwl.calendar.docs', ['mwl.calendar', 'ui.bootstrap', 'ngAnimate']) //you will need to declare your module with the dependencies ['mwl.calendar', 'ui.bootstrap', 'ngAnimate']
  .controller('ScheduleController', function(moment, alert, calendarConfig) {

    var vm = this;
    vm.calendarTitle = "Title";

  });