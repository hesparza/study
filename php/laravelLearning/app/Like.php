<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Like extends Model
{

    //Establishing relation with the post model
    public function post() {
        return $this->belongsTo('App\Post', 'post_id');
    }
}
