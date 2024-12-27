CREATE TABLE IF NOT EXISTS public.user_details
(
    user_id character varying(150) COLLATE pg_catalog."default" NOT NULL,
    user_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    user_role integer DEFAULT 0,
    CONSTRAINT user_details_pkey PRIMARY KEY (user_id)
);

INSERT INTO public.user_details VALUES ('pallavi9aug@gmail.com', 'Pallavi Verma', 0);
INSERT INTO public.user_details VALUES ('vikashmishra.m11@gmail.com', 'Vikash Kumar Mishra', 0);
