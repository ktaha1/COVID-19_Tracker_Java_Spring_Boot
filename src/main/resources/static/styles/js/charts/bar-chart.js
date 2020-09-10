(function ($) {
 "use strict";
	 /*----------------------------------------*/
	/*  1.  Bar Chart
	/*----------------------------------------*/
	Chart.defaults.global.legend.display = false;

	var ctx = document.getElementById("barchart1");
	var barchart1 = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ["Confirmed", "Recovered", "Deaths"],
			datasets: [{
				label: 'Bar Chart',
				data: [39, 19, 3],
				backgroundColor: [
					'rgb(1,192,200)',
					'rgb(0,194,146)',
					'rgb(229,47,72)',
					
				],
				borderColor: [
					'rgb(1,192,200)',  
					'rgb(0,194,146)',
					'rgb(229,47,72)',
					
				],
				borderWidth: 1
			}]
		},
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true
					}
				}]
			}
		}
	});
	
	
	
		
})(jQuery); 