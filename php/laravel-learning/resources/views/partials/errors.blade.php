@if(count($errors->all())) <!-- This errors variable is passed by the validator. The count is just a php function -->
<div class="row">
    <div class="col-md-12">
        <div class="alert alert-danger">
            <ul>
                @foreach($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    </div>
</div>
@endif