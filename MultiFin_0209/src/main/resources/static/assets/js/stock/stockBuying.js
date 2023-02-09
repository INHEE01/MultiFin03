    // Background images for sections
    $('[data-background]').each(function () {
      $(this).css('background-image', 'url(' + $(this).attr('data-background') + ')');
  });

  $('[data-background-inner]').each(function () {
      $(this).find('.inner-bg').css('background-image', 'url(' + $(this).attr('data-background-inner') + ')');
  });

  $('[data-background-color]').each(function () {
      $(this).css('background-color', $(this).attr('data-background-color'));
  });

  $('[data-color]').each(function () {
      $(this).css('color', $(this).attr('data-color'));
  });


/*주가 그래프*/
$(document).ready(function() {
  // 빈 차트를 생성한다. 
  var chart = new Chart(document.getElementById("myChart"), {
      type: 'line',
      data: {
          labels: [],
          datasets: [
                      {label: [], data: [],},
                      {label: [], data: [],}
          ],
          borderWidth: 1
      },
      options: {
                  legend: {
                      display: false
                  },
                  responsive: false,
                  scales: {
                      yAxes: [
                          {
                              ticks: {
                                  beginAtZero: true
                              }
                          }
                      ]
                  }
              }
  });

  $.ajax({
      url: URL, 
      type: 'get',
      dataType: 'json',
      success: function (data) {
          
          chart.destroy(); // 기존에 생성한 차트 오브젝트를 없앤다. 
          
          // 수신한 json 타입 데이터를 이용하여 차트를 새로 그린다. 
          chart = new Chart(document.getElementById("myChart"), {
              type: 'line',
              data: {
                  labels: data[0].label,
                  datasets: [
                      {
                          label: "height",
                          data: data[0].height,
                          borderColor: 'rgba(255, 0, 0, 1)',
                      },
                      {
                          label: "weight",
                          data: data[0].weight,
                          borderColor: 'rgba(0, 50, 255, 1)',
                      }
                  ],
                  borderWidth: 1,
                  lineTension: 0.1
              },
              options: {
                  legend: {
                      display: false
                  },
                  responsive: false,
                  scales: {
                      yAxes: [
                          {
                              ticks: {
                                  beginAtZero: true
                              }
                          }
                      ]
                  }
              }
          });
      },
      error: function (xhr, status, error) {
          // 블라블라
      },
      complete: function (data) {
          // 블라블라
      }
  })

});


/* 주가 돈 */
$(function(){
  $('.selling-amount-able').on('click', function(e) {
    let nomValue = $(".selling-amount-able").attr("value")
    console.log(nomValue);
      var sum = parseInt(nomValue || 0);
      var money = sum*61000;
      var left =  1000000-money;

      $("#selling-able-amount").val(sum);
      $("#total_money").val(money.toLocaleString());
      $("#left_money").val(left.toLocaleString());
    });
});
