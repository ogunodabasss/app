-- SEQUENCE: public.location_id_seq

-- DROP SEQUENCE IF EXISTS public.location_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.location_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.location_id_seq
    OWNER TO postgres;



-- Table: public.location

-- DROP TABLE IF EXISTS public.location;

CREATE TABLE IF NOT EXISTS public.location
(
    longitude numeric(17,14) NOT NULL,
    latitude numeric(17,14) NOT NULL,
    id bigint NOT NULL DEFAULT nextval('location_id_seq'::regclass),
    json character varying(2000) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT location_pkey PRIMARY KEY (id, latitude, longitude)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.location
    OWNER to postgres;