@extends('layouts.master')

@section('content')
    @if(false)
    <div class="row">
        <div class="col-md-12">
            <h1>Control Structures</h1>
            @if(true)
                <p>This only displays if it is true</p>
            @else
                <p>This only displays if it is true</p>
            @endif
            @for($i = 0; $i < 5; $i++)
                <p>{{ $i + 1 }} .Iteration</p>
            @endfor
            <hr>
            <h2>XSS</h2>
            {{"<script>alert('Hello');</script>"}}
            {{--{!!"<script>alert('Hello');</script>"!!}--}}
        </div>
    </div>
    @endif
    <div class="row">
        <div class="col-md-12">
            <p class="quote">The beautiful Laravel</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h1 class="post-title">Learning Laravel</h1>
            <p>This blog post will get you right on track with Laravel!</p>
            <p><a href="#">Read more...</a></p>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-12">
            <h1 class="post-title">The next steps</h1>
            <p>Understanding the basics is great, but you need to be able to make the next steps.</p>
            <p><a href="#">Read more...</a></p>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-12">
            <h1 class="post-title">Laravel 5.3</h1>
            <p>Though announced as a "minor release", Laravel 5.3 ships with some very interesting additions and features.</p>
            <p><a href="#">Read more...</a></p>
        </div>
    </div>
    <hr>
@endsection