<!DOCTYPE HTML>
<html>
<head>
    <title>Práctica #13: JMS</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="/assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="/assets/css/demo.css">



    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.js"></script>
    <script src="/assets/vendor/jquery/jquery.min.js"></script>
    <script src="/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
    <script src="/assets/vendor/chartist/js/chartist.min.js"></script>
    <script src="/assets/scripts/klorofil-common.js"></script>
    <script src="/assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="/assets/img/favicon.png">
</head>
<body>
<br>
<div class="panel-group container">
<div class="panel panel-primary">
    <div class="panel-heading">Cliente 1</div>
    <div class="panel-body chart-js">
        <canvas id="myChart" width="713" height="356" style="display: block; width: 713px; height: 356px;"></canvas>

    </div>
</div>


<br>


<div class="panel panel-primary">
    <div class="panel-heading">Cliente 2</div>
    <div class="panel-body chart-js">
        <canvas id="myChart2" width="713" height="356" style="display: block; width: 713px; height: 356px;"></canvas>

    </div>
</div>




    <!-- End PAge Content -->

    <!-- End Page wrapper  -->
</div>

</body>




<script>
    const INTERVAL = 60000;
    var humedad1 = [];
    var humedad2 = [];
    var temperatura1 =[];
    var temperatura2 = [];
    var estructura1 = {
        id: Number,
        fechaGeneracion: String,
        idDespositivo: Number,
        temperatura: Number,
        humedad: Number
    };

    var estructura2 = {
        id: Number,
        fechaGeneracion: String,
        idDespositivo: Number,
        temperatura: Number,
        humedad: Number
    };
    let timerId = setInterval(dibujarGrafica1(), INTERVAL+1,dibujarGrafica2(), INTERVAL+1);


    (function worker() {

        $.ajax({
            url: '/temp1',

            error: function () {
                console.log("An error ocurred.");
            },

            success: function (data) {
                estructura1 = data;

                temperatura1.push(estructura1.temperatura);

                humedad1.push(estructura1.humedad);

                window.myLine.update();
            },
            complete: function () {
                // Schedule the next request when the current one's complete
                setTimeout(worker, INTERVAL);
            },
            type: 'GET'
        });
    })();

    (function worker2() {
        $.ajax({
            url: '/temp2',

            error: function () {
                console.log("An error ocurred.");
            },

            success: function (data) {
                estructura2 = data;
                temperatura2.push(estructura2.temperatura);

                humedad2.push(estructura2.humedad);
                window.myLine2.update();
            },
            complete: function () {
                // Schedule the next request when the current one's complete
                setTimeout(worker2, INTERVAL);
            },
            type: 'GET'
        });
    })();



    function dibujarGrafica2() {

        window.myLine2 =new Chart(document.getElementById("myChart2"), {
            type: 'line',
            data: {
                labels: [1, 2, 3,4, 5, 6, 7, 8, 9, 10],
                datasets: [{
                    data: temperatura2,
                    label: "Temperatura",
                    borderColor: "#3e95cd",
                    fill: false
                }, {
                    data: humedad2,
                    label: "Humedad",
                    borderColor: "#e8c3b9",
                    fill: false
                }
                ]
            },
            options: {
                title: {
                    display: true,
                    text: 'Cliente #2 - Humedad/Temperatura vs Tiempo'
                }
            }
        });
    }

    function dibujarGrafica1() {




       window.myLine =  new Chart(document.getElementById("myChart"), {
            type: 'line',
            data: {
                labels: [1, 2, 3,4, 5, 6, 7, 8, 9, 10],
                datasets: [{
                    data: temperatura1,
                    label: "Temperatura",
                    borderColor: "#3e95cd",
                    fill: false
                }, {
                    data: humedad1,
                    label: "Humedad",
                    borderColor: "#e8c3b9",
                    fill: false
                }
                ]
            },
            options: {
                title: {
                    display: true,
                    text: 'Cliente #1 - Humedad/Temperatura vs Tiempo'
                }
            }
        });
    }





</script>
</html>
