--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.8
-- Dumped by pg_dump version 9.1.8
-- Started on 2013-02-25 17:24:32 PYST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 28660)
-- Name: seguridad; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA seguridad;


--
-- TOC entry 174 (class 3079 OID 11681)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1961 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 26248)
-- Dependencies: 6
-- Name: repartidor; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE repartidor (
    repartidor_id bigint NOT NULL,
    persona_id bigint NOT NULL
);


--
-- TOC entry 163 (class 1259 OID 26251)
-- Dependencies: 6 162
-- Name: repartidor_repartidor_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE repartidor_repartidor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 1962 (class 0 OID 0)
-- Dependencies: 163
-- Name: repartidor_repartidor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE repartidor_repartidor_id_seq OWNED BY repartidor.repartidor_id;


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 165 (class 1259 OID 28663)
-- Dependencies: 7
-- Name: permiso; Type: TABLE; Schema: seguridad; Owner: -; Tablespace: 
--

CREATE TABLE permiso (
    permiso_id bigint NOT NULL,
    nombre character varying(255)
);


--
-- TOC entry 164 (class 1259 OID 28661)
-- Dependencies: 7 165
-- Name: permiso_permiso_id_seq; Type: SEQUENCE; Schema: seguridad; Owner: -
--

CREATE SEQUENCE permiso_permiso_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 1963 (class 0 OID 0)
-- Dependencies: 164
-- Name: permiso_permiso_id_seq; Type: SEQUENCE OWNED BY; Schema: seguridad; Owner: -
--

ALTER SEQUENCE permiso_permiso_id_seq OWNED BY permiso.permiso_id;


--
-- TOC entry 167 (class 1259 OID 28669)
-- Dependencies: 7
-- Name: rol; Type: TABLE; Schema: seguridad; Owner: -; Tablespace: 
--

CREATE TABLE rol (
    rol_id bigint NOT NULL,
    nombre character varying(255)
);


--
-- TOC entry 169 (class 1259 OID 28675)
-- Dependencies: 7
-- Name: rol_permiso; Type: TABLE; Schema: seguridad; Owner: -; Tablespace: 
--

CREATE TABLE rol_permiso (
    rol_permiso_id bigint NOT NULL,
    permiso_id bigint,
    rol_id bigint
);


--
-- TOC entry 168 (class 1259 OID 28673)
-- Dependencies: 7 169
-- Name: rol_permiso_rol_permiso_id_seq; Type: SEQUENCE; Schema: seguridad; Owner: -
--

CREATE SEQUENCE rol_permiso_rol_permiso_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 1964 (class 0 OID 0)
-- Dependencies: 168
-- Name: rol_permiso_rol_permiso_id_seq; Type: SEQUENCE OWNED BY; Schema: seguridad; Owner: -
--

ALTER SEQUENCE rol_permiso_rol_permiso_id_seq OWNED BY rol_permiso.rol_permiso_id;


--
-- TOC entry 166 (class 1259 OID 28667)
-- Dependencies: 7 167
-- Name: rol_rol_id_seq; Type: SEQUENCE; Schema: seguridad; Owner: -
--

CREATE SEQUENCE rol_rol_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 1965 (class 0 OID 0)
-- Dependencies: 166
-- Name: rol_rol_id_seq; Type: SEQUENCE OWNED BY; Schema: seguridad; Owner: -
--

ALTER SEQUENCE rol_rol_id_seq OWNED BY rol.rol_id;


--
-- TOC entry 171 (class 1259 OID 28681)
-- Dependencies: 7
-- Name: usuario; Type: TABLE; Schema: seguridad; Owner: -; Tablespace: 
--

CREATE TABLE usuario (
    usuario_id bigint NOT NULL,
    clave_privada character varying(255),
    clave_publica character varying(255),
    contrasenha character varying(255),
    nombre character varying(255) NOT NULL,
    salt character varying(255)
);


--
-- TOC entry 173 (class 1259 OID 28690)
-- Dependencies: 7
-- Name: usuario_rol; Type: TABLE; Schema: seguridad; Owner: -; Tablespace: 
--

CREATE TABLE usuario_rol (
    usuario_rol_id bigint NOT NULL,
    rol_id bigint,
    usuario_id bigint
);


--
-- TOC entry 172 (class 1259 OID 28688)
-- Dependencies: 173 7
-- Name: usuario_rol_usuario_rol_id_seq; Type: SEQUENCE; Schema: seguridad; Owner: -
--

CREATE SEQUENCE usuario_rol_usuario_rol_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 1966 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuario_rol_usuario_rol_id_seq; Type: SEQUENCE OWNED BY; Schema: seguridad; Owner: -
--

ALTER SEQUENCE usuario_rol_usuario_rol_id_seq OWNED BY usuario_rol.usuario_rol_id;


--
-- TOC entry 170 (class 1259 OID 28679)
-- Dependencies: 171 7
-- Name: usuario_usuario_id_seq; Type: SEQUENCE; Schema: seguridad; Owner: -
--

CREATE SEQUENCE usuario_usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 1967 (class 0 OID 0)
-- Dependencies: 170
-- Name: usuario_usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: seguridad; Owner: -
--

ALTER SEQUENCE usuario_usuario_id_seq OWNED BY usuario.usuario_id;


SET search_path = public, pg_catalog;

--
-- TOC entry 1920 (class 2604 OID 26290)
-- Dependencies: 163 162
-- Name: repartidor_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY repartidor ALTER COLUMN repartidor_id SET DEFAULT nextval('repartidor_repartidor_id_seq'::regclass);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 1921 (class 2604 OID 28666)
-- Dependencies: 165 164 165
-- Name: permiso_id; Type: DEFAULT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY permiso ALTER COLUMN permiso_id SET DEFAULT nextval('permiso_permiso_id_seq'::regclass);


--
-- TOC entry 1922 (class 2604 OID 28672)
-- Dependencies: 167 166 167
-- Name: rol_id; Type: DEFAULT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY rol ALTER COLUMN rol_id SET DEFAULT nextval('rol_rol_id_seq'::regclass);


--
-- TOC entry 1923 (class 2604 OID 28678)
-- Dependencies: 168 169 169
-- Name: rol_permiso_id; Type: DEFAULT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY rol_permiso ALTER COLUMN rol_permiso_id SET DEFAULT nextval('rol_permiso_rol_permiso_id_seq'::regclass);


--
-- TOC entry 1924 (class 2604 OID 28684)
-- Dependencies: 170 171 171
-- Name: usuario_id; Type: DEFAULT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY usuario ALTER COLUMN usuario_id SET DEFAULT nextval('usuario_usuario_id_seq'::regclass);


--
-- TOC entry 1925 (class 2604 OID 28693)
-- Dependencies: 173 172 173
-- Name: usuario_rol_id; Type: DEFAULT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY usuario_rol ALTER COLUMN usuario_rol_id SET DEFAULT nextval('usuario_rol_usuario_rol_id_seq'::regclass);


SET search_path = public, pg_catalog;

--
-- TOC entry 1942 (class 0 OID 26248)
-- Dependencies: 162 1954
-- Data for Name: repartidor; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 1968 (class 0 OID 0)
-- Dependencies: 163
-- Name: repartidor_repartidor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('repartidor_repartidor_id_seq', 1, false);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 1945 (class 0 OID 28663)
-- Dependencies: 165 1954
-- Data for Name: permiso; Type: TABLE DATA; Schema: seguridad; Owner: -
--



--
-- TOC entry 1969 (class 0 OID 0)
-- Dependencies: 164
-- Name: permiso_permiso_id_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: -
--

SELECT pg_catalog.setval('permiso_permiso_id_seq', 1, false);


--
-- TOC entry 1947 (class 0 OID 28669)
-- Dependencies: 167 1954
-- Data for Name: rol; Type: TABLE DATA; Schema: seguridad; Owner: -
--

INSERT INTO rol VALUES (1, 'user');
INSERT INTO rol VALUES (2, 'admin');


--
-- TOC entry 1949 (class 0 OID 28675)
-- Dependencies: 169 1954
-- Data for Name: rol_permiso; Type: TABLE DATA; Schema: seguridad; Owner: -
--



--
-- TOC entry 1970 (class 0 OID 0)
-- Dependencies: 168
-- Name: rol_permiso_rol_permiso_id_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: -
--

SELECT pg_catalog.setval('rol_permiso_rol_permiso_id_seq', 1, false);


--
-- TOC entry 1971 (class 0 OID 0)
-- Dependencies: 166
-- Name: rol_rol_id_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: -
--

SELECT pg_catalog.setval('rol_rol_id_seq', 2, true);


--
-- TOC entry 1951 (class 0 OID 28681)
-- Dependencies: 171 1954
-- Data for Name: usuario; Type: TABLE DATA; Schema: seguridad; Owner: -
--

INSERT INTO usuario VALUES (2, NULL, NULL, '0006d7e657b49859fada03230a6b81872ea89646e9c72b9be4cabc51fbf6f7f3', 'admin', 'random_salt_value_admin');
INSERT INTO usuario VALUES (1, NULL, NULL, '3dacc82be6917e9a8bb8005b7216fa7917d4a2dbf3e84f64accfec30721e2053', 'user', 'random_salt_value_user');
INSERT INTO usuario VALUES (3, '', '', '86f94bed8fdaf70f7d531c19ce08dbc46a2625d2c48c6d18f281e500fffa05bd', 'ale', 'random_salt_value_ale');
INSERT INTO usuario VALUES (4, '', '', '908a7cec5ae7bc432c22efceeaef93af3be54d365ca0c7082c81d287336def56', 'backup', 'random_salt_value_backup');


--
-- TOC entry 1953 (class 0 OID 28690)
-- Dependencies: 173 1954
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: seguridad; Owner: -
--

INSERT INTO usuario_rol VALUES (1, 1, 1);
INSERT INTO usuario_rol VALUES (2, 2, 2);


--
-- TOC entry 1972 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuario_rol_usuario_rol_id_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: -
--

SELECT pg_catalog.setval('usuario_rol_usuario_rol_id_seq', 2, true);


--
-- TOC entry 1973 (class 0 OID 0)
-- Dependencies: 170
-- Name: usuario_usuario_id_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: -
--

SELECT pg_catalog.setval('usuario_usuario_id_seq', 4, true);


SET search_path = public, pg_catalog;

--
-- TOC entry 1927 (class 2606 OID 26317)
-- Dependencies: 162 162 1955
-- Name: repartidor_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY repartidor
    ADD CONSTRAINT repartidor_pkey PRIMARY KEY (repartidor_id);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 1929 (class 2606 OID 28695)
-- Dependencies: 165 165 1955
-- Name: permiso_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: -; Tablespace: 
--

ALTER TABLE ONLY permiso
    ADD CONSTRAINT permiso_pkey PRIMARY KEY (permiso_id);


--
-- TOC entry 1933 (class 2606 OID 28697)
-- Dependencies: 169 169 1955
-- Name: rol_permiso_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: -; Tablespace: 
--

ALTER TABLE ONLY rol_permiso
    ADD CONSTRAINT rol_permiso_pkey PRIMARY KEY (rol_permiso_id);


--
-- TOC entry 1931 (class 2606 OID 28699)
-- Dependencies: 167 167 1955
-- Name: rol_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: -; Tablespace: 
--

ALTER TABLE ONLY rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (rol_id);


--
-- TOC entry 1935 (class 2606 OID 28701)
-- Dependencies: 171 171 1955
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: -; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id);


--
-- TOC entry 1937 (class 2606 OID 28703)
-- Dependencies: 173 173 1955
-- Name: usuario_rol_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: -; Tablespace: 
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT usuario_rol_pkey PRIMARY KEY (usuario_rol_id);


--
-- TOC entry 1938 (class 2606 OID 28704)
-- Dependencies: 1930 167 169 1955
-- Name: fk2aab212512472c33; Type: FK CONSTRAINT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY rol_permiso
    ADD CONSTRAINT fk2aab212512472c33 FOREIGN KEY (rol_id) REFERENCES rol(rol_id);


--
-- TOC entry 1939 (class 2606 OID 28709)
-- Dependencies: 169 1928 165 1955
-- Name: fk2aab21252cf0f9f3; Type: FK CONSTRAINT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY rol_permiso
    ADD CONSTRAINT fk2aab21252cf0f9f3 FOREIGN KEY (permiso_id) REFERENCES permiso(permiso_id);


--
-- TOC entry 1940 (class 2606 OID 28714)
-- Dependencies: 173 1930 167 1955
-- Name: fk3118953e12472c33; Type: FK CONSTRAINT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT fk3118953e12472c33 FOREIGN KEY (rol_id) REFERENCES rol(rol_id);


--
-- TOC entry 1941 (class 2606 OID 28719)
-- Dependencies: 171 1934 173 1955
-- Name: fk3118953efa4da753; Type: FK CONSTRAINT; Schema: seguridad; Owner: -
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT fk3118953efa4da753 FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id);


--
-- TOC entry 1960 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-02-25 17:24:32 PYST

--
-- PostgreSQL database dump complete
--

