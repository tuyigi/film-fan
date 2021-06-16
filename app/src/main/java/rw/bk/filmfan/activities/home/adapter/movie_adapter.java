package rw.bk.filmfan.activities.home.adapter;import android.app.ProgressDialog;import android.content.Context;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ImageView;import android.widget.RatingBar;import android.widget.TextView;import androidx.cardview.widget.CardView;import androidx.recyclerview.widget.RecyclerView;import com.squareup.picasso.Picasso;import java.util.List;import rw.bk.filmfan.R;import rw.bk.filmfan.configs.config;import rw.bk.filmfan.helpers.clickListener;import rw.bk.filmfan.models.movie;public class movie_adapter extends RecyclerView.Adapter<movie_adapter.ViewHolder> {    Context context;    config conf;    private clickListener onMovieClickListener;    List<movie> movies;    public movie_adapter(List<movie> movies, Context context){        super();        this.movies = movies;        this.context = context;    }    @Override    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);        ViewHolder viewHolder = new ViewHolder(v);        return viewHolder;    }    @Override    public void onBindViewHolder(final ViewHolder Viewholder, final int position) {        final movie movie_data =  movies.get(position);        Viewholder.title.setText(movie_data.getTitle());        Viewholder.release_date.setText(movie_data.getRelease_date());        Viewholder.popularity.setText(movie_data.getPopularity());        Viewholder.movie_rate.setRating(movie_data.getVote_average());        Picasso.with(context)                .load(conf.BASE_URL_IMAGE+movie_data.getPoster_path())                .into(Viewholder.poster);        Viewholder.movie_card.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {                onMovieClickListener.onItemClick(position);            }        });    }    @Override    public int getItemCount() {        return movies.size();    }    public void setOnMovieClickListener(clickListener onMovieClickListener){        this.onMovieClickListener = onMovieClickListener;    }    class ViewHolder extends RecyclerView.ViewHolder{        public CardView movie_card;        public TextView title;        public ImageView poster;        public TextView release_date;        public TextView popularity;        public RatingBar movie_rate;        public ViewHolder(View itemView) {            super(itemView);            title= itemView.findViewById(R.id.title);            poster= itemView.findViewById(R.id.poster);            release_date=  itemView.findViewById(R.id.release_date);            popularity= itemView.findViewById(R.id.popularity);            movie_rate=  itemView.findViewById(R.id.movie_rate);            movie_card=itemView.findViewById(R.id.movie_card);        }    }}