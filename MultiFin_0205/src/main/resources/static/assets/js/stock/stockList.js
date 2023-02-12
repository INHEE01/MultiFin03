
$(document).ready(function() {
	$('ul.tabs li').click(function() {
		var tab_id = $(this).attr('data-tab');
		var tab_check = $(this).attr('data-tab') + 2;
		var tab_check_second = $(this).attr('data-tab') + 3;
		var tab_third = $(this).attr('data-tab') + 4;

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		$('.stock_tab_sub').removeClass('current');
		$('.stock_details').removeClass('current');
		$('.stock_description_detail_container').removeClass('current');

		$(this).addClass('current');
		$("#" + tab_id).addClass('current');
		$("#" + tab_check).addClass('current');
		$("#" + tab_check_second).addClass('current');
		$("#" + tab_third).addClass('current');
	})

});


$(function() {
	if (location.hash == "#tab-2") {
		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		$('.stock_tab_sub').removeClass('current');
		$('.stock_details').removeClass('current');
		$('.stock_description_detail_container').removeClass('current');

		var check = $('.tabs').find('li').eq(1);
		var tab_id = $(check).attr('data-tab');
		var tab_check = $(check).attr('data-tab') + 2;
		var tab_check_second = $(check).attr('data-tab') + 3;
		var tab_third = $(this).attr('data-tab') + 4;

		$(check).addClass('current');
		$("#" + tab_id).addClass('current');
		$("#" + tab_check).addClass('current');
		$("#" + tab_check_second).addClass('current');
		$("#" + tab_third).addClass('current');
	}
})





/*주가 그래프*/
/*kospi */

$.ajax({
	method: 'get',
	url: '/stock/stockRest/kosdaq',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;
		alert(dataList);
		var KOSPI = document.getElementById('KOSPI').getContext('2d');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: 'rgba(255,150,150,0.5)',
					borderColor: 'rgb(255,150,150)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 1,
					pointRadius: 0,
				}
			]
		};
		let options_now = {
			scales: {
				xAxes: [{
					display: false,
				}],
				yAxes: [{
					gridLines: {
						lineWidth: 0,
						color: 'rgb(238, 236, 236)',
					},
					ticks: {
						beginAtZero: true,
						min: 0
					}
				}]
			},
			legend: {
				display: false,
			}
		}
		var myStock = new Chart(KOSPI, {
			type: 'line',
			data: data,
			options: options_now
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});


function Hi2(dds, lds) {
	lds.push(lds[lds.length - 1] + 10);
	updateArr(dds);
}







































/*stock-graph(주가동향)*/
graphItems = document.getElementsByClassName('stock_graph'); // 그래프 개수 가져오기
for (i = 1; i <= graphItems.length; i++) { /* 그래프 그릴 부분에 id 붙여주고 하나씩 가져오기 */
	let graphId = '#stock_graph' + i;
	const ctx = document.querySelector(graphId).getContext('2d');
	const gradientFill = ctx.createLinearGradient(0, 0, 0, 150);
	gradientFill.addColorStop(0, 'rgba(225,116,116,0.5)');
	gradientFill.addColorStop(1, 'rgba(225,116,116,0)');
	var myChart = new Chart(ctx, {
		type: 'line',
		options: {
			legend: {
				display: false,
			},

			scales: {
				xAxes: [{
					gridLines: { //A축 gridLines 지우는 옵션
						display: false,
						drawBorder: false,
					},
					ticks: {
						fontSize: 0,
						fontColor: 'rgba(0,0,0,0)'
					}
				}],
				yAxes: [{
					display: false,
					gridLines: { //Y축 gridLines 지우는 옵션
						drawBorder: false,
						display: false,
					},
					ticks: {
						beginAtZero: true,
						fontSize: 0,
					}
				}]
			},
			tooltips: {
				backgroundColor: '#1e90ff'
			}
		},
		data: {
			labels: ['1', '2', '3', '4', '5', '6', '7'],
			datasets: [{
				data: [15, 13, 14, 15, 11, 15, 16, 14, 18, 16, 17, 20],
				tension: 0.0,
				borderColor: 'rgb(231, 76, 60)',
				backgroundColor: gradientFill,
				borderWidth: 2,
				fill: true,
				pointRadius: 0,
			}]
		},
		axis: {
			y: {
				show: false
			}
		}
	});
}


