using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class usuario
    {
        private string _ID;
        private string _NOMBRE;
        private string _PWD;
        private tipo_puesto _TIPO_PUESTO;
        private unidad_administrativa _UNIDAD_ADMIN;
        private IList<solicitud_capacitacion> _SOLICITUDES = new List<solicitud_capacitacion>();

        public usuario()
        {
            throw new System.NotImplementedException();
        }

        public usuario(string pID, string pNombre, string pPwd)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public string NOMBRE
        {
            get { return _NOMBRE; }
            set { _NOMBRE = value; }
        }

        public string PWD
        {
            get { return _PWD; }
            set { _PWD = value; }
        }

        public unidad_administrativa UNIDAD_ADMIN
        {
            get { return _UNIDAD_ADMIN; }
            set { _UNIDAD_ADMIN = value; }
        }

        public IList<solicitud_capacitacion> SOLICITUDES
        {
            get { return _SOLICITUDES; }
            set { _SOLICITUDES = value; }
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public usuario recuperarObjeto(string pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<usuario> recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }

        public IList<usuario> recuperarUsuario_unidad(unidad_administrativa pUnidad)
        {
            throw new System.NotImplementedException();
        }

        public void recuperarUsuario_tipo(tipo_puesto pTipo)
        {
            throw new System.NotImplementedException();
        }
    }
}
