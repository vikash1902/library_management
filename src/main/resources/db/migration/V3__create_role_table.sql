CREATE TABLE IF NOT EXISTS public.role_details
(
    role_id integer NOT NULL,
    role_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT role_details_pkey PRIMARY KEY (role_id)
);

INSERT INTO public.role_details VALUES (0, 'PUBLIC');
INSERT INTO public.role_details VALUES (1, 'ADMIN');