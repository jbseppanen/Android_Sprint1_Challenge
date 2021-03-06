package com.example.jacob.android_sprint1_challenge;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Movie>> movieList;
    private MovieRepository repo;

    public LiveData<ArrayList<Movie>> getMovieList() {
        if (movieList == null) {
            loadList();

        }
        return movieList;
    }


    private void loadList() {
        repo = new MovieRepository();
        movieList = repo.getMovies();
    }

    public void addMovie(Movie movie) {
        if(movieList != null) {
            movieList.setValue(repo.addMovie(movie));
        }
    }

    public void deleteMovie(Movie movie) {
        if(movieList != null) {
//            repo.deleteMovie(movie);
            movieList.setValue(repo.deleteMovie(movie));
        }
    }

}
