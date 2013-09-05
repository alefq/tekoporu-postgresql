-- Column: fecha

-- ALTER TABLE seguridad.usuario DROP COLUMN fecha;

ALTER TABLE seguridad.usuario ADD COLUMN fecha_ultimo_cambio_contrasenha timestamp without time zone;
ALTER TABLE seguridad.usuario ALTER COLUMN fecha_ultimo_cambio_contrasenha SET DEFAULT now();
update seguridad.usuario set fecha_ultimo_cambio_contrasenha = now();
ALTER TABLE seguridad.usuario ALTER COLUMN fecha_ultimo_cambio_contrasenha SET NOT NULL;
